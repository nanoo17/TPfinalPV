package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Poi;
import ar.edu.unju.edm.model.Turista;
import ar.edu.unju.edm.model.Turista_Poi;
import ar.edu.unju.edm.service.IPoiService;
import ar.edu.unju.edm.service.ITuristaService;
import ar.edu.unju.edm.service.ITurista_PoiService;
@Controller
public class Turista_Poi_Controller {

	@Autowired
	@Qualifier("implementacionmysql")	
	IPoiService poiService; 
	@Autowired
	@Qualifier("implementacion2mysql")	
	ITuristaService turistaService;
	@Autowired
	@Qualifier("implementacion3mysql")
	ITurista_PoiService tpService;
	
	
	//GET
	@GetMapping("/detallespoi/{codigoPoi}")
	public String cargarValoracion(Model model,@PathVariable(name="codigoPoi") Integer codigoPoi) {
		Turista_Poi cargarDetalles = tpService.crearTurista_Poi();
		System.out.println("hola");

		Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
	    
		try {
			Poi poiEncontrado = poiService.encontrarUnPoi(codigoPoi);
            model.addAttribute("unPoi", poiEncontrado);
			cargarDetalles.setOtroPoi(poiService.encontrarUnPoi(codigoPoi));
			System.out.println(cargarDetalles.getOtroPoi().getCodigoPoi());
			
			model.addAttribute("unDetalle", cargarDetalles);
		    model.addAttribute("detalles", tpService.obtenerTodosTuristas_Pois());
		    Turista turista = turistaService.encontrarPorEmail(userDetail.getUsername());
			System.out.println("se encontro turista");
		    model.addAttribute("detalles1", tpService.obtenerMisComentarios(turista));
		    model.addAttribute(turista);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	    return ("detallespoi");
	}
	
	
	@GetMapping("/detallespoi/eliminarDetalle/{idTP}")
	public String eliminarValoracion(Model model, @PathVariable(name="idTp") Integer idTP) {		
		try {	
			tpService.eliminarTurista_Poi(idTP);
		}
		catch(Exception e){
			model.addAttribute("listErrorMessage",e.getMessage());
		}			
		return "redirect:/pois";
	}



	//POST
	@PostMapping("/detallespoi/guardar/{codigoPoi}")
	public String guardarNuevoDetalle( @ModelAttribute("unDetalle") Turista_Poi nuevoDetalle,@PathVariable(name="codigoPoi") Integer codigoPoi, Model model) {		
		
		//System.out.println(valoracionService.obtenerTodasValoraciones());
		model.addAttribute("detalles", tpService.obtenerTodosTuristas_Pois().size());
		
		Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
	    
	    System.out.println(userDetail.getUsername());
	    try {
	    	Poi poiEncontrado = poiService.encontrarUnPoi(codigoPoi);
	    	nuevoDetalle.setOtroPoi(poiEncontrado);
			System.out.println(nuevoDetalle.getOtroPoi().getCodigoPoi());
			Turista turistaEncontrado = turistaService.encontrarPorEmail(userDetail.getUsername() );
			if (turistaEncontrado != null) {
				
				if (nuevoDetalle.getComentario().isEmpty()) {
					nuevoDetalle.setComentario(null);
				}
				else {
					turistaEncontrado.setPuntos(turistaEncontrado.getPuntos() + 5);
				}
				
				if(nuevoDetalle.getValoracion() != 0) {
					turistaEncontrado.setPuntos(turistaEncontrado.getPuntos() + 8);
				}
								
				poiEncontrado.setValFinal(poiEncontrado.getValFinal()+nuevoDetalle.getValoracion());
				
				turistaService.guardarTurista(turistaEncontrado);
				nuevoDetalle.setTuristaAutor(turistaEncontrado);
				tpService.guardarTurista_Poi(nuevoDetalle);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		return "redirect:/detallespoi/{codigoPoi}";
	}
	
	
}

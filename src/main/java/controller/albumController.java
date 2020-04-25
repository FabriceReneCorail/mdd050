package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipiecoles.java.eval.mdd050.service.AlbumService;
import com.ipiecoles.java.eval.mdd050.service.ArtistService;

@RestController
@RequestMapping(value="/album")
public class albumController {

@Autowired 
private  AlbumService albumService;	


 
	
}

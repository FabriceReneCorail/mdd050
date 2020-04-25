package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipiecoles.java.eval.mdd050.model.Album;
import com.ipiecoles.java.eval.mdd050.model.Artist;
import com.ipiecoles.java.eval.mdd050.service.AlbumService;
import com.ipiecoles.java.eval.mdd050.service.ArtistService;

@RestController
@RequestMapping(value="/album")
public class albumController {

@Autowired 
private  AlbumService albumService;	

@PostMapping
public ResponseEntity<Album> creerAlbum(@RequestBody Album album) {
	 album =  ((AlbumService) albumService).save(album);
	 return ResponseEntity.ok(album);
	
}
 
	
}

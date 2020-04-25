package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ipiecoles.java.eval.mdd050.model.Artist;
import com.ipiecoles.java.eval.mdd050.repository.ArtistRepository;
import com.ipiecoles.java.eval.mdd050.service.ArtistService;

@RestController
@RequestMapping (value="/artists")
public class artistController {

	@Autowired 
	private ArtistService artisteService;
	
@GetMapping("/{id}")
 public Artist findById(@PathVariable ("id") Long id) {
	if(id==null) {
		ResponseEntity.notFound().build();
	}
	return artisteService.findById(id);
	
}
	
@GetMapping("/name")
	public Page<Artist> findByNameLikeIgnoreCase(@PathVariable("name") String name,Integer page, Integer size, String sortProperty, String sortDirection){
	if(name==null) {
		ResponseEntity.notFound().build();
	}
	return artisteService.findByNameLikeIgnoreCase(name, page, size, sortProperty, sortDirection);
 };


@PostMapping("")
	public ResponseEntity<Artist> creerArtiste(@RequestBody Artist artist) {
	if (artist == null) {
		 return ResponseEntity.badRequest().build();
		 }
		 Artist artiste = ((CrudRepository<Artist, Long>) artisteService).save(artist);
		 return ResponseEntity.ok(artiste);
}
@DeleteMapping("{id}")
public ResponseEntity<String> deleteArtist(@PathVariable("id") Long id) {
	
	if (id == null) {
		 return ResponseEntity.badRequest().body("Cannot remove character with null ID");
		 }
	return artisteService.deleteArtist(id);

	
  }
 }
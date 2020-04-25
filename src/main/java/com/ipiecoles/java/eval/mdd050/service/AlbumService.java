package com.ipiecoles.java.eval.mdd050.service;

import com.ipiecoles.java.eval.mdd050.model.Album;
import com.ipiecoles.java.eval.mdd050.repository.AlbumRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;


    public Album creerAlbum(Album album) {
        return albumRepository.save(album);
    }

    public ResponseEntity<String> deleteAlbum(Long id) {
        albumRepository.deleteById(id);
        return ResponseEntity.ok("album deleted");
    }

	public Album save(Album album) {
		// TODO Auto-generated method stub
		return null;
	}

    public Album findById(Long id) {
        java.util.Optional<Album> artist = this.albumRepository.findById(id);
        if(!artist.isPresent()){
            throw new EntityNotFoundException("Impossible de trouver l'artiste d'identifiant " + id);
        }
        return artist.get();
    }

	
}

package com.ipiecoles.java.eval.mdd050.repository;

import com.ipiecoles.java.eval.mdd050.model.Artist;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
public interface ArtistRepository extends PagingAndSortingRepository<Artist, Long> {
	Page<Artist> findByNameContainingIgnoreCase(String name, Pageable pageable);
	
	

	
}



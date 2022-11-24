package com.sb.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.model.Firstdb;
import com.sb.model.Seconddb;
import com.sb.repository.*;


@RestController
public class AllController {

  private final Firstrepo fooRepo;
  private final Secondrepo barRepo;

  @Autowired
  AllController(Firstrepo fooRepo, Secondrepo barRepo) {
    this.fooRepo = fooRepo;
    this.barRepo = barRepo;
  }

  @RequestMapping("/foobar/{id}")
  public String fooBar(@PathVariable("id") Long id) {
    Optional<Firstdb> foo = fooRepo.findById(id);
    Optional<Seconddb> bar = barRepo.findById(id);

    return foo.get() + " " + bar.get() + "!";
  }

}

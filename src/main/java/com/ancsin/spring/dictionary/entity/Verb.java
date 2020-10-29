package com.ancsin.spring.dictionary.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.ancsin.spring.dictionary.entity.abstracts.WordEntity;

@Entity
@Table(name = "verb")
public class Verb extends WordEntity<VerbMeaning> {

}

package com.visma.testtask.entities;

import javax.persistence.*;

@Entity
@Table(name = "classifiers_translations")
public class ClassifierTranslation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classifier_id")
    private Long classifierId;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "language", nullable = false)
    private String language;

    // Default constructor
    public ClassifierTranslation() {
    }

    // Getters and Setters
    public Long getClassifierId() {
        return classifierId;
    }

    public void setClassifierId(Long classifierId) {
        this.classifierId = classifierId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
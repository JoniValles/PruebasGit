package uo.asw.dashboardcontroller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import uo.asw.dbmanagement.GetSuggestions;
import uo.asw.dbmanagement.model.Suggestion;
import uo.asw.dbmanagement.repository.SuggestionRepository;

import java.util.List;

@SuppressWarnings("restriction")
@Service
public class GetSuggestionsImpl implements GetSuggestions {

    @Autowired
    SuggestionRepository suggestionRepository;

    @Override
    public Suggestion getSuggestionById(Long id) {
        return suggestionRepository.findOne(id);
    }

    @Override
    public List<Suggestion> getSuggestionsByCitizen(Long citizenId) {
        throw new NotImplementedException();
    }

    @Override
    public List<Suggestion> getSuggestions() {
        return suggestionRepository.findAll();
    }
}

package business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import business.SuggestionService;
import model.Category;
import model.Citizen;
import model.Suggestion;
import model.exception.BusinessException;
import repository.SuggestionRepository;


public class SuggestionServiceImpl implements SuggestionService {

    private SuggestionRepository suggestionRepository;

    @Autowired
    public void setSuggestionRepository(SuggestionRepository sRep) {
        this.suggestionRepository = sRep;
    }
       
//    @Autowired
//    public void setConfigurationRepository(ConfigurationRepository configurationRepository) {
//		this.configurationRepository = configurationRepository;
//	}
    
    @Override
    public List<Suggestion> findAll() {
	return this.suggestionRepository.findAll();

    }

    // BORRAR MAS ADELANTE
    @Override
    public Suggestion findById(Long id) {
	return this.suggestionRepository.findOne(id);

    }

    @Override
    public Suggestion getSuggestion(Long id) {
	return suggestionRepository.findOne(id);
    }
/*
    @Override
    public List<Suggestion> findByCat(Category cat) {
	return this.suggestionRepository.findByCategoria(cat);

    }
*/
    @Override
    public void votePositivesuggestion(Suggestion sug, Citizen ciudadano) throws BusinessException {
	// TODO Auto-generated method stub

    }

    @Override
    public void voteNegativesuggestion(Suggestion sug, Citizen ciudadano) throws BusinessException {
	// TODO Auto-generated method stub

    }

    @Override
    public void deleteSuggestion(Long id) {
	suggestionRepository.delete(id);
    }
    
    

	@Override
	public Suggestion addSuggestion(Suggestion suggestion) {
		return suggestionRepository.save(suggestion);
	}

	@Override
	public void updateSuggestion(Suggestion suggestion) {
		suggestionRepository.save(suggestion);
	}

	@Override
	public List<Suggestion> getSuggestions() {
		return suggestionRepository.findAll();
	}

	@Override
	public void votePositiveSugerencia(Suggestion sug, Citizen ciudadano) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void voteNegativeSugerencia(Suggestion sug, Citizen ciudadano) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createSugerencia(Citizen citizen, Category categoria, String titulo, String contenido)
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Suggestion> findByCat(Category cat) {
		// TODO Auto-generated method stub
		return null;
	}


}

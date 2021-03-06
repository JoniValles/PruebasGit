package Manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import business.SuggestionService;
import model.Suggestion;

public class MSuggestion implements ManageSuggestion {
	
	@Autowired
	private SuggestionService suggestionService;

	
	@Override
	public void addSuggestion(Suggestion sugerencia) {
		suggestionService.addSuggestion(sugerencia);
	}

	@Override
	public void updateSuggestion(Suggestion sugerencia) {
		suggestionService.updateSuggestion(sugerencia);
	}

	@Override
	public Suggestion getSuggestion(Long id) {
		return null;
	}

	@Override
	public List<Suggestion> getSuggestions() {
		return null;
	}

}

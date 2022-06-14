package br.com.treinaweb.cleancodesolid.validators;

import org.springframework.stereotype.Component;

import br.com.treinaweb.cleancodesolid.exceptions.ValidacaoException;
import br.com.treinaweb.cleancodesolid.models.Livro;
import br.com.treinaweb.cleancodesolid.repositories.LivroRepository;

@Component
public class LivroValidator implements Validator<Livro> {

  private LivroRepository livroRepository;

  public LivroValidator(LivroRepository livroRepository) {
    this.livroRepository = livroRepository;
  }

  @Override
  public void validate(Livro model) {
    validateNullTitle(model);    
  }

  private void validateNullTitle(Livro model){
    if (model.getTitulo() == null) {
      throw new ValidacaoException("O título não pode ser nulo");
    }
    validateEmptyTitle(model);
  }

  private void validateEmptyTitle(Livro model){
    if (model.getTitulo().isEmpty()) {
      throw new ValidacaoException("O título não pode estar em branco");
    }
    validateShortTitle(model);
  }

  private void validateShortTitle(Livro model){
    if (model.getTitulo().length() < 3) {
      throw new ValidacaoException("O título não pode ter menos que 3 caracteres");
    }
    validateLongTitle(model);
  }

  private void validateLongTitle(Livro model){
    if (model.getTitulo().length() > 255) {
      throw new ValidacaoException("O título não pode ter mais que 255 caracteres");
    }
    validateDuplicatedTitle(model);
  }

  private void validateDuplicatedTitle(Livro model){
    if (livroRepository.isTituloExists(model.getTitulo())) {
      throw new ValidacaoException("Já existe um livro cadastrado com esse título");
    }
    validateIsbn(model);
  }

  private void validateIsbn(Livro model){
    if (model.getIsbn() != null && model.getIsbn().length() != 10) {
      throw new ValidacaoException("O ISBN deve ter 10 caracteres");
    }
  }  
}

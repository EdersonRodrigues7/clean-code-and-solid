package br.com.treinaweb.cleancodesolid.validators;

public interface Validator<M> {
  void validate(M model);
}

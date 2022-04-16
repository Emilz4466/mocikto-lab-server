package pl.zgora.uz.lab6.interfaces;

import java.util.List;

public interface Service<D, E> {

	List<D> find();

	D find(Long id);

	Long save(D dto);

	Long update(D dto);

	void delete(Long id);

	void assignEntityToDto(E entity, D dto);

	void assignDtoToEntity(D dto, E entity);
}

package org.dedeler.template.service;

import java.util.Collection;

import javax.validation.ValidationException;

import org.dedeler.template.dao.GenericDao;
import org.dedeler.template.model.AbstractModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class GenericService<T extends AbstractModel> {

	protected GenericDao<T> dao;

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * Instantiates a new generic service.
	 * 
	 * @param dao
	 *            the dao
	 */
	public GenericService(GenericDao<T> dao) {
		this.dao = dao;
	}

	/**
	 * Delete generic.
	 * 
	 * @param t
	 *            the t
	 */
	public void delete(T t) {
		dao.delete(t);
	}
	
	/**
	 * Delete generic by id.
	 * 
	 * @param t
	 *            the t
	 */
	public void deleteById(Class<T> klaz, long oid) {
		dao.delete(dao.findById(klaz, oid));
	}

	/**
	 * Find by id generic.
	 * 
	 * @param klaz
	 *            the klaz
	 * @param id
	 *            the id
	 * @return the t
	 */
	public T findById(Class<T> klaz, long id) {
		return dao.findById(klaz, id);
	}

	/**
	 * Save generic.
	 * 
	 * @param t
	 *            the t
	 * @return the long
	 * @throws ValidationException
	 *             the validation exception
	 */
	public long save(T t) throws ValidationException {
		return dao.save(t);
	}

	/**
	 * Update generic.
	 * 
	 * @param t
	 *            the t
	 * @return true, if successful
	 * @throws DataCreationException
	 */
	public boolean update(T t) {
		return dao.update(t);
	}
	
	/**
	 * 
	 * Finds all entries of the generic type
	 * 
	 * @param klaz
	 * @param id
	 * @return 
	 */
	public Collection<T> findAll(Class<T> klaz) {
		return dao.findAll(klaz);
	}
}

package br.com.fiap.progamer.dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import br.com.fiap.progamer.model.ProfileModel;

@Named
public class ProfileDao {

	@PersistenceContext
	private EntityManager entityManager;

	public ProfileDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public void save(ProfileModel profileModel) {
		this.entityManager.merge(profileModel);
	}

	public List<ProfileModel> findAll() {
		@SuppressWarnings("unchecked")
		TypedQuery<ProfileModel> query = (TypedQuery<ProfileModel>) entityManager.createQuery(
				"SELECT e FROM ProfileModel e");

		return query.getResultList();
	}
	
	public List<ProfileModel> findAll2() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ProfileModel> cq = cb.createQuery(ProfileModel.class);
		Root<ProfileModel> rootEntry = cq.from(ProfileModel.class);
		CriteriaQuery<ProfileModel> all = cq.select(rootEntry);
		TypedQuery<ProfileModel> allQuery = entityManager.createQuery(all);
		return allQuery.getResultList();
	}
	
}

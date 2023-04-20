package br.com.fiap.progamer.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.fiap.progamer.dao.ProfileDao;
import br.com.fiap.progamer.model.ProfileModel;

@Named
@RequestScoped
public class ProfileBean {

	ProfileModel profileModel = new ProfileModel();
	
	@Inject
	private ProfileDao profileDao;
	
	private ProfileModel selectedProfile;
	
	
	public ProfileModel getProfileModel() {
		return profileModel;
	}

	public void setProfileModel(ProfileModel profileModel) {
		this.profileModel = profileModel;
	}

	@Transactional
	public void save() {
		if (!this.profileModel.getName().isEmpty() && !this.profileModel.getProfile().isEmpty()
				&& !this.profileModel.getEmail().isEmpty() && !this.profileModel.getPasswordHash().isEmpty()) {
			profileDao.save(this.profileModel);
			this.profileModel = new ProfileModel();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "As informações foram salvas com sucesso!", "INFO"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar salvar!", "ERROR"));
		}
	}
	
	public List<ProfileModel> findAll(){
		return this.profileDao.findAll();
	}

	public ProfileModel getSelectedProfile() {
		return selectedProfile;
	}

	public void setSelectedProfile(ProfileModel selectedProfile) {
		this.selectedProfile = selectedProfile;
	}
	
	
	public static void main(String[] args) {
		List<ProfileModel> profiles = new ArrayList<>();
		
		for(ProfileModel profile : profiles) {
			System.out.println(profile.getName());
		}
	}
	
}

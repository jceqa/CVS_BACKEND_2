/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.cvs2.controller;


import java.util.List;

import py.com.cvs2.dao.CargoDao;
import py.com.cvs2.model.Cargo;

public class CargoController {

	public List<Cargo> listCargos() {
		CargoDao cargoDAO = new CargoDao();
		return cargoDAO.list();
	}

	public Cargo getCargoById(Integer id) {
		CargoDao cargoDAO = new CargoDao();
		return cargoDAO.findById(id);
	}

	public Cargo saveCargo(Cargo cargo) {
		CargoDao cargoDao = new CargoDao();
		return cargoDao.save(cargo);
	}

	public Cargo updateCargo(Cargo cargo) {
		CargoDao cargoDao = new CargoDao();
		return cargoDao.update(cargo);
	}

	public void deleteCargo(Integer id) {
		CargoDao cargoDao = new CargoDao();
		cargoDao.delete(id);
	}

}

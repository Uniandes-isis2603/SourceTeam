/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.sourceteam.festivalcine.ejbs;

import co.edu.uniandes.sourceteam.festivalcine.entities.SalaEntity;
import co.edu.uniandes.sourceteam.festivalcine.persistence.SalaPersistence;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author ya.bejarano10
 */
public class SalaLogic
{
    @Inject
    private SalaPersistence persistence;

    /**
     * Obtiene la lista de los registros de Company.
     *
     * @return Colección de objetos de CompanyEntity.
     *
     */
    public List<SalaEntity> getSalas() {
        return persistence.findAll();
    }

    /**
     * Obtiene los datos de una instancia de Company a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de CompanyEntity con los datos del Company consultado.
     *
     */
    public SalaEntity getSala(Long id) {
        return persistence.find(id);
    }

    /**
     * Se encarga de crear un Company en la base de datos.
     *
     * @param entity Objeto de CompanyEntity con los datos nuevos
     * @return Objeto de CompanyEntity con los datos nuevos y su ID.
     *
     */
    public SalaEntity createSala(SalaEntity entity) throws Exception {
        SalaEntity alreadyExist = getSala(entity.getId());
        if (alreadyExist != null) {
            throw new Exception("Ya existe una sala con ese Id");
        } else
        {
            persistence.create(entity);
        }
        return entity;
    }

    /**
     * Actualiza la información de una instancia de Company.
     *
     * @param entity Instancia de CompanyEntity con los nuevos datos.
     * @return Instancia de CompanyEntity con los datos actualizados.
     *
     */
    public  SalaEntity updateSala(SalaEntity entity) {
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de Company de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     *
     */
    public void deleteSala(Long id) {
        persistence.delete(id);
    }

    
}
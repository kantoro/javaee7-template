/**
 * 
 */
package com.jeetemplates.javaee.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.jeetemplates.javaee.domain.HelloWorld;
import com.jeetemplates.javaee.persistence.HelloWorldDao;
import com.jeetemplates.javaee.rest.api.HelloWorldServiceRest;
import com.jeetemplates.javaee.service.HelloWorldService;
import com.jeetemplates.javaee.service.dto.HelloWorldDTO;
import com.jeetemplates.javaee.util.LoggerUtils;
import com.jeetemplates.javaee.util.MapperUtils;

/**
 * Implementation of {@link HelloWorldService}
 * 
 * @author jeetemplates
 */
@Named
public class HelloWorldServiceImpl implements HelloWorldService, HelloWorldServiceRest {

    /* ************************************ */
    /* Dependencies */
    /* ************************************ */

    /**
     * {@link HelloWorldDao}
     */
    @Inject
    private HelloWorldDao helloWorldDao;

    /* ************************************ */
    /* Methods */
    /* ************************************ */

    @Override
    @Transactional
    public void create(HelloWorld entity) {
        LoggerUtils.logStartMethod("create");
        helloWorldDao.create(entity);
        LoggerUtils.logEndMethod("create");
    }

    @Override
    public List<HelloWorldDTO> retrieveAll() {
        LoggerUtils.logStartMethod("retrieveAll");
        List<HelloWorld> listEntities = helloWorldDao.retrieveAll();
        @SuppressWarnings("unchecked")
        List<HelloWorldDTO> returnValue = (List<HelloWorldDTO>) MapperUtils.mapAsList(listEntities, HelloWorldDTO.class);
        LoggerUtils.logEndMethod("retrieveAll");
        return returnValue;
    }

    /* ************************************ */
    /* Getters & Setters */
    /* ************************************ */

    /**
     * @param helloWorldDao
     *            the helloWorldDao to set
     */
    public void setHelloWorldDao(HelloWorldDao helloWorldDao) {
        this.helloWorldDao = helloWorldDao;
    }

}

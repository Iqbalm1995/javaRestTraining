/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.CodeTraining.responseTemplate;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import net.codejava.CodeTraining.responseTemplate.ResponseTemplate;
import net.codejava.CodeTraining.responseTemplate.ResponseService;

/**
 *
 * @author iqbal
 */
@Service
public class ResponseServiceImpl implements ResponseService{
    
    @Override
    public <T> ResponseTemplate<T> apiSuccess(T data) {
        ResponseTemplate<T> response = new ResponseTemplate<>();
        
        response.setStatusCode(HttpStatus.OK);
        response.setMessage("Success");
        response.setData(data);
        
        return response;
    }
}

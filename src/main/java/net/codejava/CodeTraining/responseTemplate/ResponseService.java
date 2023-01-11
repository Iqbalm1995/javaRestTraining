/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.codejava.CodeTraining.responseTemplate;

import net.codejava.CodeTraining.responseTemplate.ResponseTemplate;

/**
 *
 * @author iqbal
 */
public interface ResponseService {
    
    <T> ResponseTemplate<T> apiSuccess(T data);
}

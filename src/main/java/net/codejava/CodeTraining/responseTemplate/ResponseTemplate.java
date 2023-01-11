/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.CodeTraining.responseTemplate;

import lombok.Setter;
import lombok.Getter;
/**
 *
 * @author iqbal
 */
@Getter
@Setter
public class ResponseTemplate<T> extends ResponseBase{
    
    private T data;
}

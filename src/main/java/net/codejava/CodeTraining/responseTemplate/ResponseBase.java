/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.CodeTraining.responseTemplate;

import org.springframework.http.HttpStatus;
import lombok.Setter;
import lombok.Getter;

/**
 *
 * @author iqbal
 */
@Getter
@Setter
public class ResponseBase {
    
        private HttpStatus statusCode;
        private String message;
}

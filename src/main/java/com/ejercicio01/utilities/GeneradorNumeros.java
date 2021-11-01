/*

 */
package com.ejercicio01.utilities;

public class GeneradorNumeros {
    
    
    public Long isbnRandom(){
        
        Long ejemplares = Long.valueOf((int)(Math.random() * (99999999 - 10000000) + 1));
        System.out.println(ejemplares);
        return ejemplares;
    }
    
    
      public Integer ejemplaresRandom(){
        
        Integer ejemplares =(int)(Math.random() * (99 - 9) + 1);
        return ejemplares;
    }
}

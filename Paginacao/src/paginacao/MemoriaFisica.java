/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paginacao;

public class MemoriaFisica {

    Celula[] celMemoFisica = new Celula[512];

    public int Verificar()
    {
        for(int i = 0; i < celMemoFisica.length; i++)
        {
            if(celMemoFisica[i] == null)
            {
                return i;
            }
        }
        
        return -1;
    }
    
    
    
    
}

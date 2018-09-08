package paginacao;

import java.util.Random;



/**
 *
 * @author William
 */
public class MemoriaLogica {
    Celula[] celMemoLogica = new Celula[64];        
    
public MemoriaLogica()
{
    Random gerador = new Random();
    for(int i = 0; i < celMemoLogica.length; i++){
        celMemoLogica[i].valor = gerador.nextInt(399) + 1;
    }
}
    
}

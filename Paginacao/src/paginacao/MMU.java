package paginacao;

/**
 *
 * @author William
 */
public class MMU {

    MemoriaFisica memoFisica = new MemoriaFisica();
    MemoriaLogica memoLogica = new MemoriaLogica();

    public void Requisitar(int endFis, int endLog) {
        if (memoFisica.celMemoFisica[endFis] != null) {
            if (memoFisica.Verificar() != -1) {

                memoFisica.celMemoFisica[memoFisica.Verificar()].endereçoUsado = memoLogica.celMemoLogica[endLog];
                memoFisica.celMemoFisica[memoFisica.Verificar()].contador++;
            }
            else
            {
                LRU(endLog);
            }
        } else {
            memoFisica.celMemoFisica[endFis].endereçoUsado = memoLogica.celMemoLogica[endLog];
            memoFisica.celMemoFisica[endFis].contador++;
        }

    }

    public boolean Requisitar(int endFis) {
        if (memoFisica.celMemoFisica[endFis] != null) {
            memoFisica.celMemoFisica[endFis].contador++;
            return true;
        } else {
            System.out.println("Endereço Inexistente");
            return false;
        }
    }

    public boolean Limpar(int endFis) {
        if (memoFisica.celMemoFisica[endFis] != null) {
            memoFisica.celMemoFisica[endFis] = null;
            return true;
        } else {
            System.out.println("Endereço Inexistente");
            return false;
        }
    }

    public void Modificar(int endFis, int endLog) {
        if(Limpar(endFis) == true)
        {
            Requisitar(endFis, endLog);            
        }
    }
    
    public int LRU(int endLog)
    {
        int pos = 0;
        int aux = 400;
        for(int i = 0; i < memoFisica.celMemoFisica.length; i++)
        {
            if(memoFisica.celMemoFisica[i].contador <= aux)
            {
                aux =  memoFisica.celMemoFisica[i].contador;
                pos = i;
            }
        }
        Limpar(pos);
        memoFisica.celMemoFisica[pos].endereçoUsado = memoLogica.celMemoLogica[endLog];
        return pos;
        
    }
    
}

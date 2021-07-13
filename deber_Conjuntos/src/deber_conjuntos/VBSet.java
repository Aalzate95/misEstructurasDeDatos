/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntos;
/**
 *
 * @author alexa
 */
public class VBSet {
    private boolean [] vector;
    private int capacity = 100;
    private int efectivo;
    
    public VBSet(){
        vector = new boolean [capacity];
        efectivo = 0;
    }
    
    public boolean isEmpty(){
        return efectivo == 0;
    }
    
    public boolean add(int element){
        if (element < 0 || element >= capacity || vector[element])
            return false;
        vector[element] = true;
        efectivo++;
        return true;
    }
    
    public boolean remove(int element){
        if (element < 0 || element >= capacity || !vector[element])
            return false;
        vector[element] = false;
        efectivo--;
        return true;
    }
    
    public VBSet intersection(VBSet s){
        VBSet result = new VBSet();
        if(this.isEmpty() || s.isEmpty())
            return result;
        for (int i = 0; i < capacity; i++){
            if(this.vector[i] && s.vector[i]){
                result.vector[i] = true;
                result.efectivo++;
            }
        }return result;
    }
    
    public VBSet Union(VBSet s){
        VBSet result = new VBSet();
        if(this.isEmpty() && s.isEmpty())
            return result;
        for (int i = 0; i < capacity; i++){
            result.vector[i] = true;
            result.efectivo++;
        }return result;
    }
    
    public VBSet Diference(VBSet s){
        VBSet result = new VBSet();
        if(this.isEmpty())
            return result;
        for (int i = 0; i<capacity; i++){
            if (this.vector[i] && !s.vector[i]){
                result.vector[i] = true;           
                result.efectivo++;              
            }
        }return result;
    }
}

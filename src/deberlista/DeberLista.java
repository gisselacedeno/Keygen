package deberlista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;
/**
 *
 * @author GisselitaPC
 */
public class DeberLista 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ArrayList<Empleado> ListaEmpleado = new ArrayList<>();
        
        ListaEmpleado.add(new Empleado("131374308-8", "Gissela Cedeño", "Manta", 22, 1000,"Gerente General"));
        ListaEmpleado.add(new Empleado("131447874-9", "Elsa Pilozo", "Montecristi", 27, 350,"Recursos Humanos"));
        ListaEmpleado.add(new Empleado("132452191-1", "Kevin de la A", "Jipijapa", 25, 450,"Producción"));
        ListaEmpleado.add(new Empleado("131315489-4", "Jose Toledo", "Manta", 25, 365,"Sistemas"));
        ListaEmpleado.add(new Empleado("151225798-9", "Jonathan Reyes", "Guayaquil", 24, 400,"Mercadotecnia"));
        ListaEmpleado.add(new Empleado("131179841-0", "Karina Lopez", "Manta", 25, 256,"Finanzas"));
        ListaEmpleado.add(new Empleado("121346587-9", "Laura Lopez", "Quito", 22, 365,"Sistemas"));
        ListaEmpleado.add(new Empleado("131789459-1", "José Choez", "Manta", 23, 300,"Finanzas"));
        ListaEmpleado.add(new Empleado("152224598-8", "Analia Menendez", "Guayaquil", 22, 450,"Producción"));
        ListaEmpleado.add(new Empleado("131879130-2", "Hernan Cedeño", "Manta", 27, 365,"Sistemas"));
        ListaEmpleado.add(new Empleado("151258471-3", "Luis Payo", "Guayaquil", 23, 400,"Mercadotecnia"));
        ListaEmpleado.add(new Empleado("137894561-8", "Johan Moreira", "Jipijapa", 30, 350,"Recursos Humanos"));
        ListaEmpleado.add(new Empleado("130598745-8", "Johana Lopez", "Montecristi", 28, 365,"Sistemas"));
        ListaEmpleado.add(new Empleado("131349765-5", "Pedro Fermin", "Manta", 30, 450,"Producción"));
        ListaEmpleado.add(new Empleado("120145679-8", "Fernanda Delgado", "Quito", 22, 400,"Mercadotecnia"));
        ListaEmpleado.add(new Empleado("130215411-7", "Josue Zambrano", "Manta", 22, 365,"Sistemas"));
        ListaEmpleado.add(new Empleado("150120014-9", "Diana Mata", "Guayaquil", 28, 256,"Producción"));
        ListaEmpleado.add(new Empleado("121310857-1", "Eduardo Moreira", "Quito", 22, 365,"Sistemas"));
        ListaEmpleado.add(new Empleado("131479707-6", "Karla Sánchez", "Manta", 32, 450,"Producción"));
        ListaEmpleado.add(new Empleado("131487910-0", "Andres Alonso", "Montecristi", 22, 365,"Sitemas"));
        ListaEmpleado.add(new Empleado("135487901-0", "Victor Zambrano", "Montecristi", 20, 400,"Mercadotecnia"));
        ListaEmpleado.add(new Empleado("157894132-1", "Ana Maria Pincay", "Guayaquil", 22, 365,"Sistemas"));
        ListaEmpleado.add(new Empleado("131014781-9", "Luis Zambrano", "Montecristi", 22, 350,"Recursos Humanos"));
        ListaEmpleado.add(new Empleado("152145879-1", "Lucia Méndez", "Guayaquil", 26, 400,"Mercadotecnia"));
        ListaEmpleado.add(new Empleado("121214791-0", "Hugo Cedeño", "Quito", 30, 450,"Producción"));
        
        //1  
        System.out.println("1.- Empleado con mayor edad:");
        Collections.sort(ListaEmpleado, (p1, p2)-> p2.getEdad() - p1.getEdad());
        ListaEmpleado.stream().limit(1).forEach(p-> {System.out.println(p.getNombre()); System.out.println(p.getEdad()+"Años\n");});
               
        //2
        System.out.println("2.- Empleados con menor sueldo:");
        Predicate<Empleado> PredicadoMenorSueldo = (p-> p.getSueldo() <= 300.00);
        ListaEmpleado.stream().filter(PredicadoMenorSueldo).forEach(p-> {System.out.println(p.getNombre()); System.out.println("$"+p.getSueldo()+"\n");}); 
       
        //3
        System.out.println("3.- Empleados que pertenecen a la ciudad de Manta y trabajan en el Departamento de Sistemas:");
        Predicate<Empleado> PredicadoCiudadDepartamento = (p-> "Manta".equals(p.getCiudad()) && "Sistemas".equals(p.getDepartamento()));
        ListaEmpleado.stream().filter(PredicadoCiudadDepartamento).forEach(p-> {System.out.println(p.getNombre()); System.out.println(p.getCiudad()); System.out.println(p.getDepartamento()+"\n");});
        
        //4
        System.out.println("4.- Empleados con cédula de Manabí y cuyo sueldo supera los 500 dólares:");
        Predicate<Empleado> PredicadoCedulaSueldo = (p-> "13".equals(p.getCedula().substring(0, 2))  && p.getSueldo() > 500);
        ListaEmpleado.stream().filter(PredicadoCedulaSueldo).forEach(p-> {System.out.println(p.getNombre()); System.out.println(p.getCiudad()); System.out.println(p.getCedula()); System.out.println(p.getDepartamento()+"\n");}); 

        //5          
        Predicate<Empleado> PredicadoPromedioSueldo = (p-> p.getSueldo() > 400);
        double PromedioSueldo = ListaEmpleado.stream().filter(PredicadoPromedioSueldo).limit(5).mapToDouble(p-> p.getSueldo()).average().getAsDouble();
        System.out.println("5.- El promedio del sueldo de los 5 empleados con el mayor salario es:\n$"+PromedioSueldo+"\n");
         
        //6
        Predicate<Empleado> PredicadoSueldosQueNoPertenecenManta = (p-> !"Manta".equals(p.getCiudad()));
        double SumaSueldo = ListaEmpleado.stream().filter(PredicadoSueldosQueNoPertenecenManta).mapToDouble(p-> p.getSueldo()).sum();
        System.out.println("6.- La suma de sueldos de los empleados que no pertenecen a Manta es:\n$"+SumaSueldo+"\n");
        
        //7
        Predicate<Empleado> PredicadoMenoresEdades = (p-> p.getEdad() < 25);
        int PromedioEdades = (int)ListaEmpleado.stream().filter(PredicadoMenoresEdades).mapToDouble(p-> p.getEdad()).average().getAsDouble();
        System.out.println("7.- El promedio de las edades entre los empleados menores de 25 años es:\n"+PromedioEdades +  " Años\n"); 
        
        //8
        Predicate<Empleado> PredicadoSueldoBasico = (p-> p.getSueldo() == 350);
        int PromedioEdadesSueldoBasico = (int)ListaEmpleado.stream().filter(PredicadoSueldoBasico).mapToDouble(p-> p.getEdad()).average().getAsDouble();
        System.out.println("8.- El promedio de las edades en los empleados con sueldo básico es:\n"+PromedioEdadesSueldoBasico+" Años\n");
        
        //9
        System.out.println("9.- Número de empleados por departamento:");
        Predicate<Empleado> PredicadoDepartamentoGerencia = (p-> p.getDepartamento().startsWith("Gerencia General"));
        int DepGerencia = (int)ListaEmpleado.stream().filter(PredicadoDepartamentoGerencia).count();
        System.out.println("Departamento de Gerente General:\n"+DepGerencia+" Empleados");
        
        Predicate<Empleado> PredicadoDepartamentoRecursosHumanos = (p-> p.getDepartamento().startsWith("Recursos Humanos"));
        int DepRRHH = (int)ListaEmpleado.stream().filter(PredicadoDepartamentoRecursosHumanos).count();
        System.out.println("Departamento de Recursos Humanos:\n"+DepRRHH+" Empleados");
        
        Predicate<Empleado> PredicadoDepartamentoProduccion = (p-> p.getDepartamento().startsWith("Producción"));
        int DepProduccion = (int)ListaEmpleado.stream().filter(PredicadoDepartamentoProduccion).count();
        System.out.println("Departamento de Produccion:\n"+DepProduccion+" Empleados");
        
        Predicate<Empleado> PredicadoDepartamentoSistemas = (p-> p.getDepartamento().startsWith("Sistemas"));
        int DepSistemas = (int)ListaEmpleado.stream().filter(PredicadoDepartamentoSistemas).count();
        System.out.println("Departamento de Sistemas:\n"+DepSistemas+" Empleados");
        
        Predicate<Empleado> PredicadoDepartamentoMercadotecnia = (p-> p.getDepartamento().startsWith("Mercadotecnia"));
        int DepMercadotecnia = (int)ListaEmpleado.stream().filter(PredicadoDepartamentoMercadotecnia).count();
        System.out.println("Departamento de Mercadotecnia:\n"+DepMercadotecnia+" Empleados");
        
        Predicate<Empleado> PredicadoDepartamentoFinanzas = (p-> p.getDepartamento().startsWith("Finanzas"));
        int DepFinanzas = (int)ListaEmpleado.stream().filter(PredicadoDepartamentoFinanzas).count();
        System.out.println("Departamento de Finanzas:\n"+DepFinanzas+" Empleados\n");
        
        //10
        System.out.println("10.- Número de empleados por ciudad:");
        Predicate<Empleado> PredicadoManta = (p-> p.getCiudad().startsWith("Manta"));
        int Manta = (int)ListaEmpleado.stream().filter(PredicadoManta).count();
        System.out.println("Manta\n"+Manta+" Empleados");
        
        Predicate<Empleado> PredicadoMontecristi = (p-> p.getCiudad().startsWith("Montecristi"));
        int Montecristi = (int)ListaEmpleado.stream().filter(PredicadoMontecristi).count();
        System.out.println("Montecristi\n"+Montecristi+" Empleados");
        
        Predicate<Empleado> PredicadoJipijapa = (p-> p.getCiudad().startsWith("Jipijapa"));
        int Portoviejo = (int)ListaEmpleado.stream().filter(PredicadoJipijapa).count();
        System.out.println("Jipijapa\n"+Portoviejo+" Empleados");
        
        Predicate<Empleado> PredicadoGuayaquil = (p-> p.getCiudad().startsWith("Guayaquil"));
        int Guayaquil = (int)ListaEmpleado.stream().filter(PredicadoGuayaquil).count();
        System.out.println("Guayaquil\n"+Guayaquil+" Empleados");
        
        Predicate<Empleado> PredicadoQuito = (p-> p.getCiudad().startsWith("Quito"));
        int Quito = (int)ListaEmpleado.stream().filter(PredicadoQuito).count();
        System.out.println("Quito\n"+Quito+" Empleados");
    }
}
    


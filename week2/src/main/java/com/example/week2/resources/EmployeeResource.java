package com.example.week2.resources;

import com.example.week2.enums.EmployeeStatus;
import com.example.week2.models.Employee;
import com.example.week2.services.EmployeeService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Path("/employee")
@Slf4j
public class EmployeeResource {
    private EmployeeService employeeService;



    public EmployeeResource(){
        employeeService = new EmployeeService();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getEmp(@PathParam("id") long id){

        try {
            Optional<Employee> emp = employeeService.findById(id);


            if(emp.isPresent()){
//                String result = new ObjectMapper().writeValueAsString(emp);
//                log.info("RESULTTTTTTTT {}", result);
//                return Response.ok(emp).build();
                return Response.ok(emp.get()).build();
            }


        }
        catch (Exception exception){
            log.error("ERROR MESSSAGEEEEEE {}", exception.getMessage(), exception);
            exception.printStackTrace();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Employee> employeeList = employeeService.getAllEmp();
        return Response.ok(employeeList).build();
    }

    @GET
    @Path("/test")
    public Response getTest(){
        return Response.ok().entity("OK").build();
    }

    @POST
    @Path("/insert")
    @Produces("application/json")
    public Response insert(Employee employee){
        employeeService.insert(employee);

        return Response.ok(employee).build();
    }


    @PUT
    @Path("/update")
    @Produces("application/json")
    public Response update(Employee employee){
        employeeService.update(employee);

        return Response.ok(employee).build();
    }

    @POST
    @Path("/setStatus")
    @Produces("application/json")
    public Response setStatus(Employee employee, EmployeeStatus status){
        employeeService.setStatus(employee, status);

        return Response.ok(employee).build();
    }





}

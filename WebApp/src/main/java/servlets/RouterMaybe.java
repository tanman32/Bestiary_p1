package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controllers.EntryController;
import repos.EntryImplementation;
import repos.EntryRepo;
import services.EntryImplementationService;
import services.EntryService;

import java.io.IOException;
import java.util.Arrays;

public class RouterMaybe {

    //This is us trying to use Dependency Injection to help decouple our classes from having to manage
    // Objects (dependencies) that they need
    static EntryRepo EN = new EntryImplementation();
    static EntryService ES = new EntryImplementationService(EN);
    static EntryController EC = new EntryController(ES);

    /**
     * This method will delegate other methods on the Controller layer of our application
     * to process the request
     * @param request - the HTTP Request
     * @param response - the HTTP Response
     */
    public static void getProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String uri = request.getRequestURI();
        System.out.println(uri);
    //localhost:8080/WebApp/PrimeServlet
        String[] uriTokens = uri.split("/");
        System.out.println(Arrays.toString(uriTokens));

        switch (uriTokens.length) {
            //if the uriTokens only has two elements, a blank element and the project name, then nothing to process.
            case 0:
            case 1:
            case 2: {
                response.sendError(404);
                break;
            }
            //if the uriTokens is exactly 3 then it also has the collection name, but no path parameter.
            case 3: {
                //Call our getAll<Insert Entity Here> methods.
                if(("monsters").equals(uriTokens[2])) EC.getEntries(request, response);
                else response.sendError(400, "Collection does not exist");
                break;
            }
            case 4: {
                //Call our get<Insert Entity Here> by Id service method.
                request.setAttribute("id", uriTokens[3]);
                if(("monsters").equals(uriTokens[2])) EC.getEntryById(request, response);
                break;
            }
            default: {
                response.sendError(400);
                break;
            }
        }

    }

    public static void postProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {


        String uri = request.getRequestURI();
        System.out.println(uri);

        String[] uriTokens = uri.split("/");
        System.out.println(Arrays.toString(uriTokens));

        switch (uriTokens.length) {
            //if the uriTokens only has two elements, a blank element and the project name, then nothing to process.
            case 0:
            case 1:
            case 2: {
                response.sendError(404);
                break;
            }
            //if the uriTokens is exactly 3 then it also has the collection name, but no path parameter.
            case 3: {
                //Call our getAll<Insert Entity Here> methods.
                if (("monsters").equals(uriTokens[2])) EC.addEntry(request, response);
                else response.sendError(400, "Collection does not exist");
                break;
            }
            default: {
                response.sendError(400);
                break;
            }

        }

    }

    public static void putProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String uri = request.getRequestURI();
        System.out.println(uri);

        String[] uriTokens = uri.split("/");
        System.out.println(Arrays.toString(uriTokens));

        switch (uriTokens.length) {
            //if the uriTokens only has two elements, a blank element and the project name, then nothing to process.
            case 0:
            case 1:
            case 2: {
                response.sendError(404);
                break;
            }
            //if the uriTokens is exactly 3 then it also has the collection name, but no path parameter.
            case 4: {
                int id = 0;
                String input = uriTokens[3];

                if(input.matches("[0-9]+")) {
                    id = Integer.parseInt(input);
                } else {
                    response.sendError(400, "ID is not a number");
                    return;
                }

                request.setAttribute("id", id);
                if (("monsters").equals(uriTokens[2])) EC.updateEntry(request, response);
                else response.sendError(400, "Collection does not exist");
                break;
            }
            default: {
                response.sendError(400);
                break;
            }

        }

    }

    public static void deleteProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String uri = request.getRequestURI();
        System.out.println(uri);

        String[] uriTokens = uri.split("/");
        System.out.println(Arrays.toString(uriTokens));

        switch (uriTokens.length) {
            //if the uriTokens only has two elements, a blank element and the project name, then nothing to process.
            case 0:
            case 1:
            case 2: {
                response.sendError(404);
                break;
            }
            //if the uriTokens is exactly 3 then it also has the collection name, but no path parameter.
            case 4: {
                int id = 0;
                String input = uriTokens[3];

                if(input.matches("[0-9]+")) {
                    id = Integer.parseInt(input);
                } else {
                    response.sendError(400, "ID is not a number");
                    return;
                }

                request.setAttribute("id", id);
                if (("monsters").equals(uriTokens[2])) EC.deleteEntry(request, response);
                else response.sendError(400, "Collection does not exist");
                break;
            }
            default: {
                response.sendError(400);
                break;
            }

        }
    }
}


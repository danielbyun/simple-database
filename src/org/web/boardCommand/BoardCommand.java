package org.web.boardCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface BoardCommand {
    void executeQueryCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}

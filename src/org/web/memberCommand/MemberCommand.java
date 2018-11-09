package org.web.memberCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MemberCommand {
    void executeQueryCommand(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}

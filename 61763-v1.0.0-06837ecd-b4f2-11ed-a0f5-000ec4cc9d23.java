/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE90_LDAP_Injection__Servlet_listen_tcp_68a.java
Label Definition File: CWE90_LDAP_Injection__Servlet.label.xml
Template File: sources-sink-68a.tmpl.java
*/
/*
 * @description
 * CWE: 90 LDAP Injection
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: A hardcoded string
 * BadSink:  unchecked data leads to LDAP injection
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE90_LDAP_Injection;

import testcasesupport.*;

//!! other imports come from the label definitions

import javax.naming.*;
import javax.naming.directory.*;
import javax.servlet.http.*;

import java.util.Hashtable;
import java.io.IOException;

import org.apache.commons.lang.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

import java.util.logging.Logger;

public class CWE90_LDAP_Injection__Servlet_listen_tcp_68a extends AbstractTestCaseServlet
{

    public static String data;

    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        Logger log_bad = Logger.getLogger("local-logger");

        data = ""; /* init data */

        /* Read data using a listening tcp connection */

        ServerSocket listener = null;
        Socket sock = null;
        BufferedReader buffread = null;
        InputStreamReader instrread = null;
        try {
            /* read input from socket */
            listener = new ServerSocket(39543);
            sock = listener.accept();

            instrread = new InputStreamReader(sock.getInputStream());
            buffread = new BufferedReader(instrread);
            data = buffread.readLine();
        }
        catch( IOException ioe )
        {
            log_bad.warning("Error with stream reading");
        }
        finally {
            /* clean up stream reading objects */
            try {
                if( buffread != null )
                {
                    buffread.close();
                }
            }
            catch( IOException ioe )
            {
                log_bad.warning("Error closing buffread");
            }
            finally {
                try {
                    if( instrread != null )
                    {
                        instrread.close();
                    }
                }
                catch( IOException ioe )
                {
                    log_bad.warning("Error closing instrread");
                }
            }

            /* clean up socket objects */
            try {
                if( sock != null )
                {
                    sock.close();
                }
            }
            catch( IOException e )
            {
                log_bad.warning("Error closing sock");
            }
            finally {
                try {
                    if( listener != null )
                    {
                        listener.close();
                    }
                }
                catch( IOException e )
                {
                    log_bad.warning("Error closing listener");
                }
            }
        }

        (new CWE90_LDAP_Injection__Servlet_listen_tcp_68b()).bad_sink(request, response);
    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        (new CWE90_LDAP_Injection__Servlet_listen_tcp_68b()).goodG2B_sink(request, response);
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }

}

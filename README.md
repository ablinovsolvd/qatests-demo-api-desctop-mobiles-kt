# How to Start Selenium Server and Run UI Tests

---

## 1. Check if Selenium Server is Running

Before starting a new server, check if something is already using port 4444 (the default Selenium port):

```bash
lsof -i :4444
```

If you see any processes listed, you should stop them first.

---

## 2. Stop Any Existing Selenium Server

Kill the process using port 4444:

```bash
kill -9 <Number>
```
Replace `<Number>` with the PID (process ID) from the previous command.

---

## 3. Start Selenium Server

Start Selenium in standalone mode (update `selenium-server.jar` to match your file name):

```bash
java -jar selenium-server.jar standalone
```

Leave this terminal window open while running your tests!

---

## 4. Run Your UI Tests

Once the server is running, you can execute your UI tests from your IDE or command line.  
Standard Maven command:

```bash
mvn test
```

Your tests will connect to Selenium Server (port 4444) and launch browsers for automated UI checks.

---

**Tip:**  
If you get connection errors, double-check that the server is running and accessible at `http://localhost:4444`.

---
```
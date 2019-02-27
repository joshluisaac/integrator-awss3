
## OWASP Top Ten 2017 Category A2 - Broken Authentication
### CWE-613: Insufficient Session Expiration

Case 1:
The following snippet was taken from a J2EE web.xml deployment descriptor in which the session-timeout parameter is explicitly defined (the default value depends on the container). In this case the value is set to -1, which means that a session will never expire.

```xml
<web-app>
[...snipped...]

<session-config>
<session-timeout>-1</session-timeout>
</session-config>
</web-app>
```

Security control measures: Set sessions/credentials expiration date.

> The lack of proper session expiration may improve the likely success of certain attacks. For example, an attacker may intercept a session ID, possibly via a network sniffer or Cross-site Scripting attack. Although short session expiration times do not help if a stolen token is immediately used, they will protect against ongoing replaying of the session ID. In another scenario, a user might access a web site from a shared computer (such as at a library, Internet cafe, or open work environment). Insufficient Session Expiration could allow an attacker to use the browser's back button to access web pages previously accessed by the victim.

## Input Validation
### File Upload
1. Check the type of file being uploaded.
1. Have a filter to reject files which aren't in the supported list.
1. Rename the file after upload using a random generated name.
2. Check if file exceed the max defined limit.
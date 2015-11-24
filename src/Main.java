
/*
   Licensed to the Apache Software Foundation (ASF) under one
   or more contributor license agreements.  See the NOTICE file
   distributed with this work for additional information
   regarding copyright ownership.  The ASF licenses this file
   to you under the Apache License, Version 2.0 (the
   "License"); you may not use this file except in compliance
   with the License.  You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing,
   software distributed under the License is distributed on an
   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
   KIND, either express or implied.  See the License for the
   specific language governing permissions and limitations
   under the License.
 */

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {

  public static void main(String[] args) {
    if (args.length == 1){
      String password = args[0];
      String encryptedPassword = getEncryptedPassword(password);
      System.out.println("Encrypted ("+password+"): "+encryptedPassword);
    }else{
      System.out.println("Call with just the password to encrypt.");
    }
  }

  /**
   * Encrypt password by using SHA-256 algorithm, encryptedPassword length is 32 bits
   * @param clearTextPassword
   * @return
   * @throws NoSuchAlgorithmException
   * reference http://java.sun.com/j2se/1.4.2/docs/api/java/security/MessageDigest.html
   */
  public static String getEncryptedPassword(String clearTextPassword)   {

    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      md.update(clearTextPassword.getBytes());
      return new sun.misc.BASE64Encoder().encode(md.digest());
    } catch (NoSuchAlgorithmException e) {
      System.out.println("Failed to encrypt password. " +  e);
    }
    return "";
  }

}
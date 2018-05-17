/*
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.springframework.security.saml;

import java.util.List;

import org.springframework.security.saml.key.SimpleKey;
import org.springframework.security.saml.saml2.Saml2Object;
import org.springframework.security.saml.saml2.signature.Signature;
import org.springframework.security.saml.saml2.signature.SignatureException;

public interface SamlValidator {
    /**
     * Validates a signature on a SAML object. Returns the key that validated the signature
     * @param saml2Object - a signed object to validate
     * @param verificationKeys a list of keys to use for validation
     * @return the key that successfully validated the signature
     * @throws NullPointerException if the underlying implementation is null (no object that contains a signature)
     * @throws IllegalArgumentException if the object was not signed
     * @throws SignatureException if object failed signature validation
     */
    Signature validateSignature(Saml2Object saml2Object, List<SimpleKey> verificationKeys) throws SignatureException;

    /**
     * Performs an object validation on the respective object
     * @param saml2Object
     * @return - the results of the validation
     */
    ValidationResult validate(Saml2Object saml2Object);
}

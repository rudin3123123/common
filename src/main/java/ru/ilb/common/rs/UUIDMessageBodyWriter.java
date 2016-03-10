/*
 * Copyright 2016 Bystrobank.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.ilb.common.rs;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.UUID;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author slavb
 */
@Produces("text/plain")
@Provider
public class UUIDMessageBodyWriter implements MessageBodyWriter<UUID> {

    @Override
    public boolean isWriteable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return UUID.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(UUID t, Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return -1;
    }

    @Override
    public void writeTo(UUID t, Class<?> type, Type type1, Annotation[] antns, MediaType mt, MultivaluedMap<String, Object> mm, OutputStream out) throws IOException, WebApplicationException {
        out.write(t.toString().getBytes());
    }

}
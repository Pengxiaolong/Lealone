/**
 * Copyright (c) 2011 Yahoo! Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. See accompanying LICENSE file.
 */

package com.codefollower.yourbase.omid.tso;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BufferPool {

    private static BlockingQueue<ByteArrayOutputStream> pool = new LinkedBlockingQueue<ByteArrayOutputStream>();

    public static ByteArrayOutputStream getBuffer() {
        ByteArrayOutputStream baos = pool.poll();
        if (baos != null)
            return baos;
        return new ByteArrayOutputStream(1500);
    }

    public static void pushBuffer(ByteArrayOutputStream buffer) {
        pool.add(buffer);
    }
}
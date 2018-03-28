/*
 * Copyright 2017 Onshape, Inc..
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

package org.memcached.jcache.rules;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RepeatRule implements TestRule {
    @Override
    public Statement apply(Statement base, Description description) {
        Repeat repeat = description.getAnnotation(Repeat.class);

        if (repeat == null) {
            return base;
        }

        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                for (int i = 0; i < repeat.times(); i++) {
                    base.evaluate();
                }
            }
        };
    }
}

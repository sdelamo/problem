package org.zalando.problem;

/*
 * ⁣​
 * Problem
 * ⁣⁣
 * Copyright (C) 2015 Zalando SE
 * ⁣⁣
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
 * ​⁣
 */

import javax.annotation.concurrent.Immutable;

import static com.google.common.base.Preconditions.checkState;

@Immutable
public abstract class ThrowableProblem extends RuntimeException implements Problem {

    @Deprecated
    public ThrowableProblem() {
        
    }

    public ThrowableProblem(Throwable cause) {
        super(cause);
    }

    @Override
    public ThrowableProblem getCause() {
        final Throwable cause = super.getCause();
        if (cause == null) {
            return null;
        }

        checkState(cause instanceof ThrowableProblem, "Expected throwable problem cause, but got %s", cause);
        
        return (ThrowableProblem) cause;
    }
}

/*
 * Copyright 2015 RefineriaWeb
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
 * limitations under the License.
 */

package domain.foundation;

import rx.Subscriber;

/**
 * Provides a default subscriber for any
 * @see domain.foundation.Presenter
 */
public abstract class DefaultSubscriber<D> extends Subscriber<D> {
    @Override public void onCompleted() {}

    @Override public void onError(Throwable e) {
        onCompleted();
    }

    @Override public void onNext(D data) {}
}

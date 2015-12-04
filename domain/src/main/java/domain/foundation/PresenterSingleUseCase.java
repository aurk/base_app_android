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

import domain.sections.Locale;
import domain.sections.Wireframe;

/**
 * Base class for any Presenter with only one use case.
 * @param <V> The view interface attached to this presenter.
 * @param <U> The use case used in this presenter.
 * @see  Presenter
 * @see  BaseView
 * @see  UseCaseSingleRepository
 */
public abstract class PresenterSingleUseCase<V extends BaseView, U extends UseCaseSingleRepository> extends Presenter<V> {
    protected final U useCase;

    public PresenterSingleUseCase(Wireframe wireframe, Locale locale, U useCase) {
        super(wireframe, locale);
        this.useCase = useCase;
    }

    @Override public void dispose() {
        useCase.dispose();
    }
}

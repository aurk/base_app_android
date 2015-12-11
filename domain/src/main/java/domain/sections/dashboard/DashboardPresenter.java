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

package domain.sections.dashboard;

import java.util.List;

import javax.inject.Inject;

import domain.foundation.DefaultSubscriber;
import domain.foundation.Presenter;
import domain.sections.Locale;
import domain.sections.Wireframe;

public class DashboardPresenter extends Presenter<DashboardView, GetMenuItemsUseCase> {

    @Inject DashboardPresenter(GetMenuItemsUseCase useCase, Wireframe wireframe, Locale locale) {
        super(useCase, wireframe, locale);
    }

    @Override public void attachView(DashboardView view) {
        super.attachView(view);
        useCase.execute(new DefaultSubscriber<List<ItemMenu>>() {
            @Override public void onNext(List<ItemMenu> itemsMenuDashboards) {
                view.loadMenus(itemsMenuDashboards);
                view.showUsers();
            }
        });
    }

    public void setSelectedItemMenu(ItemMenu itemMenu) {
        if (itemMenu.getId() == GetMenuItemsUseCase.ID_USERS)
            view.showUsers();
        else if (itemMenu.getId() == GetMenuItemsUseCase.ID_USER)
            view.showUser();
        else
            view.showUserSearch();
    }
}

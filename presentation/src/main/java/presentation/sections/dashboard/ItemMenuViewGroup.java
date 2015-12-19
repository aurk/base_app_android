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

package presentation.sections.dashboard;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import base.app.android.R;
import domain.sections.dashboard.ItemMenu;
import presentation.utilities.recyclerview_adapter.ViewWrapper;

@EViewGroup(R.layout.item_menu_view_group) public class ItemMenuViewGroup extends FrameLayout implements ViewWrapper.Binder<ItemMenu> {
    @ViewById protected ImageView iv_icon;
    @ViewById protected TextView tv_title;

    public ItemMenuViewGroup(Context context) {
        super(context);
    }

    public ItemMenuViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override public void bind(ItemMenu itemMenu, int position) {
        iv_icon.setImageResource((Integer)itemMenu.getImageResource());
        tv_title.setText(itemMenu.getTitle());
    }
}

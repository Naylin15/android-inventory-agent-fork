/**
 *  LICENSE
 *
 *  This file is part of Flyve MDM Inventory Agent for Android.
 * 
 *  Inventory Agent for Android is a subproject of Flyve MDM.
 *  Flyve MDM is a mobile device management software.
 *
 *  Flyve MDM is free software: you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License
 *  as published by the Free Software Foundation; either version 3
 *  of the License, or (at your option) any later version.
 *
 *  Flyve MDM is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  ---------------------------------------------------------------------
 *  @copyright Copyright © 2018 Teclib. All rights reserved.
 *  @license   GPLv3 https://www.gnu.org/licenses/gpl-3.0.html
 *  @link      https://github.com/flyve-mdm/android-inventory-agent
 *  @link      https://flyve-mdm.com
 *  @link      http://flyve.org/android-inventory-agent
 *  ---------------------------------------------------------------------
 */

package org.flyve.inventory.agent.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import org.flyve.inventory.agent.R;
import java.util.HashMap;
import java.util.List;

public class DrawerAdapter extends BaseAdapter {

	private List<HashMap<String, String>> data;
	private LayoutInflater inflater = null;

	public DrawerAdapter(Activity activity, List<HashMap<String, String>> data) {
		this.data = data;
		inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	/**
	 * Get count of the data
	 * @return int the data size 
	 */
	@Override
	public int getCount() {
		return this.data.size();
	}

	/**
	 * Get the data item associated with the specified position
     * @param position of the item whose data we want
	 * @return Object the data at the specified position
 	 */
	@Override
	public Object getItem(int position) {
		return position;
	}

	/**
	 * Get the row ID associated with the specified position
	 * @param position of the item whose row ID we want
	 * @return long the ID of the item at the specified position
	 */
	@Override
	public long getItemId(int position) {
		return position;
	}

	/**
	 * Get a View that displays the data at the specified position
	 * @param position of the item within the adapter's data set of the item whose View we want
	 * @param convertView the old View to reuse, if possible
	 * @param parent the parent that this View will eventually be attached to
	 * @return View a View corresponding to the data at the specified position
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		HashMap<String, String> hashdata;
		hashdata = this.data.get(position);
		
		View vi = inflater.inflate(R.layout.list_item_drawer, null);

		View viewSeparator = vi.findViewById(R.id.viewSeparator);
		if(hashdata.containsKey("separator") && "true".equalsIgnoreCase(hashdata.get("separator"))) {
			viewSeparator.setVisibility(View.VISIBLE);
		} else {
			viewSeparator.setVisibility(View.GONE);
		}

		TextView txtTitle = vi.findViewById(R.id.txtTitle);
        ImageView img = vi.findViewById(R.id.img);

		Context context = img.getContext();
		int iddw = context.getResources().getIdentifier(hashdata.get("img"), "drawable", context.getPackageName());
		img.setImageResource(iddw);

		String title = hashdata.get("name");
		txtTitle.setText(title);

		return vi;
	}
}

package com.muzima.view.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.muzima.R;
import com.muzima.adapters.ListAdapter;
import com.muzima.adapters.notification.NotificationsAdapter;
import com.muzima.controller.NotificationController;
import com.muzima.view.MuzimaListFragment;

public abstract class NotificationListFragment extends MuzimaListFragment implements ListAdapter.BackgroundListQueryTaskListener{

    protected NotificationController notificationController;
    protected FrameLayout progressBarContainer;
    protected LinearLayout noDataView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View formsLayout = setupMainView(inflater,container);
        list = (ListView) formsLayout.findViewById(R.id.list);
        progressBarContainer = (FrameLayout) formsLayout.findViewById(R.id.progressbarContainer);
        noDataView = (LinearLayout) formsLayout.findViewById(R.id.no_data_layout);

        setupNoDataView(formsLayout);

        // Todo no need to do this check after all list adapters are implemented
        if (listAdapter != null) {
            list.setAdapter(listAdapter);
            list.setOnItemClickListener(this);
            ((NotificationsAdapter)listAdapter).setBackgroundListQueryTaskListener(this);
        }
        list.setEmptyView(formsLayout.findViewById(R.id.no_data_layout));

        return formsLayout;
    }

    protected View setupMainView(LayoutInflater inflater, ViewGroup container){
        return inflater.inflate(R.layout.layout_list, container, false);
    }

    @Override
    public void onQueryTaskStarted() {
        list.setVisibility(View.INVISIBLE);
        noDataView.setVisibility(View.INVISIBLE);
        progressBarContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void onQueryTaskFinish() {
        list.setVisibility(View.VISIBLE);
        progressBarContainer.setVisibility(View.INVISIBLE);
    }
}

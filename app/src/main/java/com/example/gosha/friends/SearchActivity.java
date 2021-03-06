package com.example.gosha.friends;

import android.content.ContentResolver;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.gosha.friendsapp.R;

import java.util.List;

/**
 * Created by GOSHA on 2/12/2016.
 */
public class SearchActivity extends FragmentActivity
implements LoaderManager.LoaderCallbacks<List<Friend>> {
    private static final String LOG_TAG = SearchActivity.class.getSimpleName();
    private FriendsCustomAdapter mFriendsCustomAdapter;
    private static int LOADER_ID  = 2;
    private ContentResolver mContentResolver;
    private List<Friend> friendsRetrieved;
    private ListView listView;
    private EditText mSearchEditText;
    private Button mSearchFriendButton;
    private String matchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
        listView = (ListView) findViewById(R.id.searchResultsList);
        mSearchEditText = (EditText) findViewById(R.id.searchName);
        mSearchFriendButton = (Button) findViewById(R.id.searchButton);
        mContentResolver = getContentResolver();
        mFriendsCustomAdapter = new FriendsCustomAdapter(SearchActivity.this, getSupportFragmentManager());
        listView.setAdapter(mFriendsCustomAdapter);

        mSearchFriendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matchText = mSearchEditText.getText().toString();
                getSupportLoaderManager().initLoader(LOADER_ID++, null, SearchActivity.this);
            }
        });

    }

    @Override
    public Loader<List<Friend>> onCreateLoader(int id, Bundle args) {
        return new FriendsSearchListLoader(SearchActivity.this, FriendsContract.URI_TABLE, this.mContentResolver, matchText);

    }

    @Override
    public void onLoadFinished(Loader<List<Friend>> loader, List<Friend> friends) {
        mFriendsCustomAdapter.setData(friends);
        this.friendsRetrieved = friends;
    }

    @Override
    public void onLoaderReset(Loader<List<Friend>> loader) {
        mFriendsCustomAdapter.setData(null);
    }
}

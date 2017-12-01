package test.bwie.com.retrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lj on 2017/12/1.
 */

public class IAdapter extends RecyclerView.Adapter<IAdapter.IViewHolder> {

    private Context context;
    private List<Bean.ResultBean.ListBean> list;

    public IAdapter(Context context, List<Bean.ResultBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public IViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = View.inflate(context, R.layout.layout_item, null);

        return new IViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IViewHolder holder, int position) {

        holder.textview.setText(list.get(position).getTitle());
        holder.simp.setImageURI(list.get(position).getFirstImg());

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }


    static class IViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textview)
        TextView textview;
        @BindView(R.id.simp)
        SimpleDraweeView simp;

        IViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}

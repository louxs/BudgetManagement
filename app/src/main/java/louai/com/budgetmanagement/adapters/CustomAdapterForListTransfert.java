
/**
 * Created by louai on 02/08/2016.
 */


package louai.com.budgetmanagement.adapters;

        import android.content.Context;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.List;

        import louai.com.budgetmanagement.R;

/**
 * Created by louai on 02/08/2016.
 */



public class CustomAdapterForListTransfert extends RecyclerView.Adapter<CustomAdapterForListTransfert.ViewHolderC> {
    List<String> dataList;
    Context context;
    RadioGroup grp;
    private RadioButton lastCheckedRB = null;


    public CustomAdapterForListTransfert(Context context, List<String> dataList) {
        this.context = context;
        this.dataList = dataList;

    }

    @Override
    public ViewHolderC onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.transfert_item_list, viewGroup, false);
        return new ViewHolderC(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderC viewHolder, int i) {
        viewHolder.descriptionVirement.setText("28-06-2016  13:11:40");
        viewHolder.valeurTransfertr.setText("100000");
        viewHolder.transfertFromTo.setText("Personal Expense/louai");
        viewHolder.transfertStatut.setText("0/1");
        viewHolder.transfertDate.setText("28-02-2016");
        viewHolder.typeDeTransfert.setText("Carte de crédit");

//        Get the first letter of list item
        //letter = String.valueOf(dataList.get(i).charAt(0));

    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

    class ViewHolderC extends RecyclerView.ViewHolder {
        TextView descriptionVirement;
        TextView valeurTransfertr;
        TextView transfertFromTo;
        TextView transfertStatut;
        TextView transfertDate;
        TextView typeDeTransfert;

        public ViewHolderC(View itemView) {
            super(itemView);

            descriptionVirement = (TextView) itemView.findViewById(R.id.descriptionVirement);
            valeurTransfertr = (TextView) itemView.findViewById(R.id.valeurTransfertr);
            transfertFromTo = (TextView) itemView.findViewById(R.id.transfertFromTo);
            transfertStatut = (TextView) itemView.findViewById(R.id.transfertStatut);
            transfertDate = (TextView) itemView.findViewById(R.id.transfertDate);
            typeDeTransfert = (TextView) itemView.findViewById(R.id.typeDeTransfert);
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    Toast.makeText(null, "re", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}